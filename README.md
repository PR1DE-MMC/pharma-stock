# PHARMA-STOCK - CLI
## A Command Line Client for Pharamceutical Stock Management

## 🏷️ Contributors : 
 - Chihaoui Med Mahdi
 - Youssef Chalghoumi
 - Islem Bargaoui
 - Oumaima Ayari
## ✨ Project Setup

### ☕ Java
 This Project uses [Coretto Java 17](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html) as it offers the longest LTS duration!

### 📦️ Databases
This project is using the File system as its database!

## 🔖 Version Control
This project uses Github as a VCS

## 🗃️ Folder/Package Architecture
```
src
│       │   └── tekup/tic1n/moyi
│       │           ├── menus : Contains The Menu Logic & Hashmaps.
│       │           ├── models : Contains Our Entities/Models along with enums.
│       │           ├── services : contains all the business logic/magic!
│       │           │           ├── exceptions  : Some Custom exceptions!
│       │           │           ├── impl  : Services & Business Logic!
│       │           │           ├── singletons  : singleton Design Pattern for our services and Scanner!
│       │           ├── utils  : contains utility classes in order to reduce code duplication!
```