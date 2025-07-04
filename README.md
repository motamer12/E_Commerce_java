# 🛍️ E-Commerce OOP Java Project

Welcome to the **E-Commerce Java OOP Project**, a clean and modular implementation of an e-commerce system demonstrating core Object-Oriented Programming concepts in Java! 🚀

---

## ✨ Overview

This project simulates a simple online shopping experience. Customers can add different product types to a shopping cart, including digital products, shipped items, and perishable goods. At checkout, it calculates totals, handles shipping logic, updates inventory, and prints a detailed receipt.  

The architecture is designed to be **clean, extensible, and easy to understand**, making it perfect as an educational or starter project for Java OOP enthusiasts.

---

## 💡 Features

- ✅ **BaseProduct** abstract class with common properties (name, price, quantity).
- 💾 **DigitalProduct** — virtual products without shipping.
- 📦 **ShippedProduct** — physical items with shipping weight.
- 🥫 **PerishableProduct** — items with expiration dates and shipping.
- 🥛 **PerishableShipped** — items with expiration dates, not necessarily shipped.
- 💼 **Interfaces**:
  - `Product`: Core product behaviors.
  - `Shippable`: Defines shipping-related behaviors.
  - `Expirable`: For products with expiration dates.
- 👤 **Customer class** — tracks balance and identity.
- 🛒 **Cart class** — supports adding/updating products, calculating subtotal, and identifying shippable items.
- 🚚 **ShippingService & CheckOutService** — decoupled services for shipping fees and checkout process.
- 🧾 Prints detailed receipt after checkout with subtotal, shipping, and final amount.

---

## ⚙️ How it works

1️⃣ Customer creates a cart and adds products (digital, shipped, or perishable).  
2️⃣ Cart validates product availability and updates quantities.  
3️⃣ During checkout:
   - Subtotal and shipping fees are calculated.
   - Customer's balance is reduced.
   - Product stock is updated.
   - Shipment notice and detailed receipt are printed.

---
💻 Tech Stack

Java: The backbone of the application, delivering robust and scalable logic.
Object-Oriented Programming (OOP): Harnesses inheritance, polymorphism, encapsulation, and abstraction for a clean codebase.


🚀 Get Started
Ready to explore this e-commerce gem? Clone the repo, dive into the code, and run the project to see it in action! Extend it with new features, tweak the services, or experiment with your own product types. The possibilities are endless! 🌍
git clone <repository-url>
cd e-commerce-system


🌟 Why This Project?
This project is more than just code—it's a showcase of OOP principles in action, designed to inspire developers to build scalable, maintainable systems. Whether you're learning Java or crafting your own e-commerce platform, this project is your springboard to greatness! 💡
Contributions are welcome! Fork the repo, add your flair, and let's build the future of e-commerce together! 🛍️

## 🗺️ System Flow Chart

```mermaid
flowchart TD
    A[Start: Customer] --> B[Create Cart]
    B --> C[Add Product to Cart]
    C --> D{Product Available?}
    D -- Yes --> E[Update Quantity]
    D -- No --> F[Show Error]
    E --> G[Check Out]
    G --> H[Calculate Subtotal & Shipping]
    H --> I{Balance Sufficient?}
    I -- Yes --> J[Reduce Balance & Update Stock]
    J --> K[Print Receipt & Shipment Notice]
    I -- No --> L[Show Insufficient Balance Error]
    K --> M[End]
    L --> M


