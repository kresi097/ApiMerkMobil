# Merk Mobil API

API ini menyediakan endpoint untuk mengelola data **Merk Mobil** serta autentikasi user menggunakan JWT. Proyek ini dibangun menggunakan **Java Spring Boot**, **JWT** untuk otentikasi, dan **PostgreSQL** sebagai database.

---

## Using

- **Java Spring Boot**: Framework
- **JWT (JSON Web Token)**: otentikasi
- **PostgreSQL**: Database
- **Maven**: Dependency and build tool
- **Postman**: Testing API.

---

## SpringBoot Dependencies
- **Spring Web**
- **Spring Data JPA**
- **PostgreSQL Driver**
- **Spring Security**
- **Lombok**

---
## Catatan
- Response API disajikan dalam format JSON.
- JWT digunakan untuk melindungi endpoint, sehingga hanya user yang terautentikasi yang dapat mengakses operasi tertentu.
- Proyek ini dibuat dengan pemisahan yang jelas antara Controller, Service, Repository, dan Security, sehingga memudahkan maintaince atau penambahan fitur
---
## Feature
- List Semua Data Merk Mobil
- Menambahkan Data Merk Mobil
- Menampilkan Data Merk Mobil
- Mengubah Data Merk Mobil
- Delete Data Merk Mobil
- Error Handler endpoint

# API Specification - Merk Mobil API

## Overview

API ini menyediakan endpoint untuk mengelola data **Merk Mobil** serta autentikasi user menggunakan JWT.  
**Base URL:** `http://localhost:8080`

---

## Authentication

### POST `/auth/login`

**Deskripsi:**  
Melakukan autentikasi user dan mengembalikan token JWT jika kredensial valid.

**Request Body:**
```json
{
  "username": "admin",
  "password": "password"
}
```
**Response Body (Success) :**
```json
{
  "token": "JWT_TOKEN_STRING"
}
```

## Create Merk

### POST `/api/merk-mobil`

**Deskripsi:**  
Membuat data Merk Mobil baru.

Request Header :

- Bearer Token : Token

**Request Body :**
```json
{
  "nama": "Ford",
  "tahunBerdiri": 1903,
  "negaraAsal": "Amerika Serikat"
}
```

## List Merk

### GET `/api/merk-mobil`

**Deskripsi:**  
Mengambil semua data Merk Mobil.

Request Header :

- Bearer Token : Token

**Response Body (Success) :**
```json
[
  {
    "id": 1,
    "nama": "Toyota",
    "tahunBerdiri": 1937,
    "negaraAsal": "Jepang"
  },
  {
    "id": 2,
    "nama": "Honda",
    "tahunBerdiri": 1948,
    "negaraAsal": "Jepang"
  }
]
```

## List Merk By Id

### GET `/api/merk-mobil/{id}`

**Deskripsi:**  
Mengambil data Merk Mobil berdasarkan ID.

Request Header :

- Bearer Token : Token

**Response Body (Success) :**
```json
[
  {
    "id": 1,
    "nama": "Toyota",
    "tahunBerdiri": 1937,
    "negaraAsal": "Jepang"
  }
]
```
**Response Body (Success) :**
```json
{
  "id": 3,
  "nama": "Ford",
  "tahunBerdiri": 1903,
  "negaraAsal": "Amerika Serikat"
}
```

## Update Merk

### PUT `/api/merk-mobil/{id}`

**Deskripsi:**  
Memperbarui data Merk Mobil berdasarkan ID.

Request Header :

- Bearer Token : Token

**Request Body :**
```json
{
  "nama": "Updated Ford",
  "tahunBerdiri": 1903,
  "negaraAsal": "Amerika Serikat"
}

```

**Response Body (Success) :**
```json
{
  "id": 3,
  "nama": "Updated Ford",
  "tahunBerdiri": 1903,
  "negaraAsal": "Amerika Serikat"
}

```

## Delete Merk

### PUT `/api/merk-mobil/{id}`

**Deskripsi:**  
Menghapus data Merk Mobil berdasarkan ID.

Request Header :

- Bearer Token : Token




