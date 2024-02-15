package com.karthik.learningportalnew.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.karthik.learningportalnew.dto.FavouriteCourseDTO;
import com.karthik.learningportalnew.dto.RegisteredCourseDTO;
import com.karthik.learningportalnew.dto.UserDTO;
import com.karthik.learningportalnew.entity.CourseEntity;
import com.karthik.learningportalnew.entity.CourseEntity.Category;
import com.karthik.learningportalnew.entity.FavouriteCourseEntity;
import com.karthik.learningportalnew.entity.RegisteredCourseEntity;
import com.karthik.learningportalnew.entity.UserEntity;
import com.karthik.learningportalnew.mapper.FavouriteMapper;
import com.karthik.learningportalnew.mapper.RegisteredMapper;
import com.karthik.learningportalnew.mapper.UserMapper;
import com.karthik.learningportalnew.repository.CourseRepository;
import com.karthik.learningportalnew.repository.FavouriteCourseRepository;
import com.karthik.learningportalnew.repository.RegisteredCourseRepository;
import com.karthik.learningportalnew.repository.UserRepository;
import com.karthik.learningportalnew.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final CourseRepository courseRepository;
	private final RegisteredCourseRepository registeredCourseRepository;
	private final FavouriteCourseRepository favouriteCourseRepository;

	public UserServiceImpl(UserRepository userRepository, RegisteredCourseRepository registeredCourseRepository,
			CourseRepository courseRepository, FavouriteCourseRepository favouriteCourseRepository) {
		this.userRepository = userRepository;
		this.registeredCourseRepository = registeredCourseRepository;
		this.courseRepository = courseRepository;
		this.favouriteCourseRepository = favouriteCourseRepository;
	}

	//get all users
	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();

	}

	@Override
	public Optional<UserEntity> getUser(Long id) {
		return userRepository.findById(id);
	}

	//deleting an user
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);

	}

	//adding and user by a admin
	@Override
	public UserDTO addUser(UserDTO user) {
		UserEntity userEntity = UserMapper.populateUser(user);
		UserEntity resUserEntity = userRepository.save(userEntity);
		UserDTO resUserDTO = UserMapper.userEntitytoDTO(resUserEntity);
		return resUserDTO;
	}

	//get courses by category
	@Override
	public List<CourseEntity> getCoursesByCategory(Category category) {
		return courseRepository.findByCategory(category);
	}

	//logging in an user
	@Override
	public Optional<UserEntity> loginUser(Long userId) {
		return userRepository.findById(userId);
	}

	//registering an user
	@Override
	public UserDTO registerUser(UserDTO user) {

		UserEntity userEntity = UserMapper.populateUser(user);
		UserEntity resUserEntity = userRepository.save(userEntity);
		UserDTO resUserDTO = UserMapper.userEntitytoDTO(resUserEntity);
		return resUserDTO;
	}

	//purchasing a course 
	@Override
	@Transactional
	public RegisteredCourseDTO purchaseCourse(Long courseId, Long userId) {

		//finding if the course and user exist
		Optional<CourseEntity> optionalCourse = courseRepository.findById(courseId);
		Optional<UserEntity> optionalUser = userRepository.findById(userId);

		//if course and user exist
		if (!optionalCourse.isEmpty() && !optionalUser.isEmpty()) {
			CourseEntity course = optionalCourse.get();
			UserEntity user = optionalUser.get();

			//set course and user reference in registered course
			RegisteredCourseEntity registeredCourse = new RegisteredCourseEntity();
			registeredCourse.setCourse(course);
			registeredCourse.setUser(user);

			//saving the registered course
			RegisteredCourseEntity regCourse = registeredCourseRepository.save(registeredCourse);
			RegisteredCourseDTO registeredCourseDTO = RegisteredMapper.regCourseEntitytoDTO(regCourse);

			return registeredCourseDTO;
		}
		return new RegisteredCourseDTO();
	}

	//adding a course to favourite
	@Override
	public FavouriteCourseDTO favouriteCourse(Long registrationId) {
		// finding if the registered course exist
		Optional<RegisteredCourseEntity> regCourse = registeredCourseRepository.findById(registrationId);

		//if it exist the find it in favourites and return it
		if (regCourse.isPresent()) {
			RegisteredCourseEntity reigisteredCourse = regCourse.get();
			FavouriteCourseEntity favouriteCourse = new FavouriteCourseEntity();
			favouriteCourse.setRegisteredCourse(reigisteredCourse);

			FavouriteCourseEntity favCourse = favouriteCourseRepository.save(favouriteCourse);
			FavouriteCourseDTO favouriteCourseDTO = FavouriteMapper.favCourseEntitytoDTO(favCourse);
		}
		return new FavouriteCourseDTO();
	}

	//listing all your favourite courses
	@Override
	public List<FavouriteCourseEntity> seeFavouriteCourses(Long userId) {
		//finding all registered courses
		List<RegisteredCourseEntity> registeredCourses = registeredCourseRepository.findByUserId(userId);
		//List to store favourite courses for a specific user
		List<FavouriteCourseEntity> favouriteCourses = new ArrayList<>();

		// Extract IDs of registered courses
		List<Long> registeredCourseIds = registeredCourses.stream().map(RegisteredCourseEntity::getRegistrationId)
				.collect(Collectors.toList());

		// Find favorite courses for the registered courses
		for (Long id : registeredCourseIds) {
			List<FavouriteCourseEntity> favouriteCoursesForRegistrationId = favouriteCourseRepository
					.findByRegistrationId(id);
			favouriteCourses.addAll(favouriteCoursesForRegistrationId);
		}

		return favouriteCourses;

	}

}
