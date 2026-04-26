# Spring Lombok MapStruct Logger Demo

Small Spring Boot movie API project demonstrating DTO mapping, layered service design, Lombok-based constructor injection, and logging in a Java backend.

## Project Summary

This repository contains a compact backend application centered on a movie CRUD workflow. It is useful as a focused practice project for:

- Spring Boot API structure
- DTO mapping
- repository and service layers
- controller-level logging
- Lombok annotations for constructor wiring

## Main Application

The actual code lives under:

```text
demo01/
```

Key package areas include:

- `Controller/`
- `Service/`
- `Repository/`
- `Entity/`

## What The Controller Shows

The movie controller currently exposes actions for:

- creating a movie
- fetching all movies
- fetching a movie by ID
- deleting one movie
- deleting all movies

This makes the repo a good example of a compact CRUD API learning project.

## Why Keep This Repo Public

It works well as supporting evidence that you have hands-on experience with:

- Java backend fundamentals
- Spring Boot request handling
- DTO/entity separation
- basic application logging

## Suggested Local Run

```bash
cd demo01
./mvnw spring-boot:run
```

On Windows PowerShell:

```powershell
cd demo01
.\mvnw.cmd spring-boot:run
```

## Notes

This repo looks best when framed as a focused backend practice project rather than a flagship portfolio piece.
