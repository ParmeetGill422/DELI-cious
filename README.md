![sandwich shop logo](https://github.com/user-attachments/assets/4b383c82-584a-4a99-a22f-9da4685625be)
# 🥪 DELI-cious: Sandwich Shop CLI Application

**DELI-cious** is an interactive, object-oriented Java CLI application that emulates a point-of-sale system for a custom sandwich shop. It allows users to build their own sandwiches, choose from signature selections, add sides, chips, and beverages, and receive a detailed receipt upon checkout.

---

## 📦 Features

- 🍞 **Custom Sandwich Builder**  
Customize your sandwich from the ground up — select your bread type, portion size, fresh toppings, premium add-ons, sauces, and whether you’d like it toasted.

- 🥤 **Drinks, Chips, and Sides**  
  Pile on extras with your order — mix and match from a range of beverages, chip flavors, and signature sauces such as Thousand Island or au jus for the perfect finish.

- ⭐ **Signature Sandwiches**  
  Enjoy fan favorites like the BLT and Philly Cheese Steak

- 🧾 **Receipt Generation**  
  Orders are stored as timestamped .txt files within the receipts/ directory.

- ✅ **Object-Oriented Structure**  
Follows clean, modular object-oriented practices, utilizing structured relationships, flexible behavior, and abstract design patterns to ensure reusable and maintainable code.

---

## 📸 Screenshots

### 🏠 Home Screen  
![Mainmenu](https://github.com/user-attachments/assets/304dc055-4fce-4ab9-88ff-55172f52e217)

### 🛒 Order Builder 
![Ordermenu](https://github.com/user-attachments/assets/85fc2d66-65ff-420e-b304-e8b7796f44d9)

### 🧾 Checkout Summary  
![Checkoutmenu](https://github.com/user-attachments/assets/b3c89eb2-d9ea-450e-a53d-baab31d8ad5a)

---

## 🔍 Interesting Code: Dynamic Item Grouping

To reduce clutter in the cart, identical items are grouped using quantity indicators:

```java
public static String formatWithCounts(List<String> items) {
    Map<String, Integer> countMap = new LinkedHashMap<>();
    for (String item : items) {
        countMap.put(item, countMap.getOrDefault(item, 0) + 1);
    }
    return countMap.entrySet().stream()
        .map(e -> e.getKey() + (e.getValue() > 1 ? " x" + e.getValue() : ""))
        .collect(Collectors.joining(", "));
}
```
## 📊 Diagram
![Final](https://github.com/user-attachments/assets/eeeae936-ea33-48a2-ac89-d0f3db86cf93)
