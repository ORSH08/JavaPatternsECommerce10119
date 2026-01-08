# JavaPatternsECommerce10119
A comprehensive Java-based trade market simulation. Implements a custom generic ArrayList with Memento for state management, alongside Singleton, Factory, and Observer patterns to manage e-commerce workflows.

# Java Trade Market System

A robust console-based e-commerce platform simulation developed in Java. This project demonstrates advanced Object-Oriented Programming (OOP) concepts, custom data structure implementation, and the practical application of standard Design Patterns.

## Overview

The **Trade Market System** allows users to simulate a digital marketplace. It supports two types of users: **Buyers** and **Sellers**. Sellers can list products (regular or special packaging), while buyers can manage shopping carts, execute payments, and view their order history.

The core of the project focuses on architecture and memory management, featuring a custom implementation of an `ArrayList` with state preservation capabilities.

## Key Features

* **User Management:** distinct workflows for Buyers (purchasing) and Sellers (inventory management).
* **Inventory System:** Support for product categorization and special packaging options using inheritance.
* **Shopping Cart & History:**
    * Real-time cart management.
    * Order history tracking.
    * **Order Cloning:** Ability to restore/copy a previous cart from history into the current cart.
* **Custom Collections:** A manually implemented generic `MyArrayList<E>` that includes:
    * Custom `Iterator` and `ListIterator`.
    * **Memento Pattern** integration to save and restore the list state.

## Design Patterns Implemented

This project showcases the implementation of several Gang of Four (GoF) design patterns:

| Pattern | Usage in Project |
| :--- | :--- |
| **Singleton** | `MarketManagmentFacade` ensures a single entry point and state manager for the system. |
| **Factory Method** | Used in `PersonFactory` and `ProductFactory` to encapsulate object creation logic based on types. |
| **Memento** | Implemented within `MyArrayList` to save snapshots of the list state and restore them later (Undo functionality). |
| **Observer** | Implemented via `MyButton` and `Observer` interface to simulate event-driven updates. |
| **Facade** | `MenuFacade` simplifies the interaction between the user interface (Console) and the complex system logic. |
| **Iterator** | Custom `ConcreteIterator` and `ConcreteListIterator` to traverse the custom collection. |

## Project Structure

* **Model:** `Buyer`, `Seller`, `Product`, `Cart`.
* **Logic/Management:** `TradeMarketSystem`, `BuyerManagment`, `SellerManagment`.
* **Infrastructure:** `MyArrayList` (Custom Collection), `InputManagment` (Validations).
* **View/Interface:** `Main`, `OutputManagment`, `MenuFacade`.

## How to Run

1.  Clone the repository.
2.  Open the project in your favorite IDE (Eclipse, IntelliJ, VS Code).
3.  Run the `Main.java` file.
4.  Follow the on-screen console menu to:
    * Add Buyers/Sellers.
    * Add Products to Sellers.
    * Shop and Checkout.
    * Test the "Memento" feature (Save/Restore state options in the menu).

---
