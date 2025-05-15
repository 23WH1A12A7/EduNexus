import React, { useState, useEffect } from "react";

export default function ItemExchange() {
  const [activeTab, setActiveTab] = useState("buy");
  const [items, setItems] = useState([]);
  const [formData, setFormData] = useState({
    title: "",
    description: "",
    price: "",
    category: "",
    item_name: "",
    status: "Available",
  });

  useEffect(() => {
    if (activeTab === "buy") {
      fetch("http://localhost:8080/api/items/all")
        .then((res) => res.json())
        .then((data) => {
          const availableItems = data.filter((item) => item.status === "Available");
          setItems(availableItems);
        })
        .catch(console.error);
    }
  }, [activeTab]);

  const handleTabClick = (tab) => {
    setActiveTab(tab);
  };

  const handleInputChange = (e) => {
    setFormData((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleSellSubmit = (e) => {
    e.preventDefault();

    const newItem = {
      title: formData.title,
      description: formData.description,
      price: parseFloat(formData.price),
      category: formData.category,
      item_name: formData.item_name,
      status: formData.status,
      owner_id: 1, // Replace with actual logged-in user id dynamically if possible
    };

    fetch("http://localhost:8080/api/items/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newItem),
    })
      .then((res) => res.json())
      .then(() => {
        alert("Item added successfully!");
        setFormData({
          title: "",
          description: "",
          price: "",
          category: "",
          item_name: "",
          status: "Available",
        });
      })
      .catch(console.error);
  };

  return (
    <div className="container my-4">
      <h2 className="text-center mb-4">Item Exchange</h2>

      {/* Tabs */}
      <ul className="nav nav-tabs justify-content-center mb-4">
        <li className="nav-item">
          <button
            className={`nav-link ${activeTab === "buy" ? "active" : ""}`}
            onClick={() => handleTabClick("buy")}
          >
            Buy
          </button>
        </li>
        <li className="nav-item">
          <button
            className={`nav-link ${activeTab === "sell" ? "active" : ""}`}
            onClick={() => handleTabClick("sell")}
          >
            Sell
          </button>
        </li>
      </ul>

      {/* Buy Tab Content */}
      {activeTab === "buy" && (
        <>
          {items.length === 0 ? (
            <p className="text-center">No available items right now.</p>
          ) : (
            <div className="row">
              {items.map((item) => (
                <div key={item.id} className="col-md-4 mb-4">
                  <div className="card h-100 shadow-sm">
                    <div className="card-body d-flex flex-column">
                      <h5 className="card-title">{item.title}</h5>
                      <h6 className="card-subtitle mb-2 text-muted">{item.category}</h6>
                      <p className="card-text flex-grow-1">{item.description}</p>
                      <p className="fw-bold mb-3">Price: ${item.price.toFixed(2)}</p>
                      <button className="btn btn-primary mt-auto">Buy</button>
                    </div>
                  </div>
                </div>
              ))}
            </div>
          )}
        </>
      )}

      {/* Sell Tab Content */}
      {activeTab === "sell" && (
        <form onSubmit={handleSellSubmit} className="mx-auto" style={{ maxWidth: "600px" }}>
          <div className="mb-3">
            <label htmlFor="title" className="form-label">
              Title
            </label>
            <input
              type="text"
              className="form-control"
              id="title"
              name="title"
              value={formData.title}
              onChange={handleInputChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="description" className="form-label">
              Description
            </label>
            <textarea
              className="form-control"
              id="description"
              name="description"
              rows="3"
              value={formData.description}
              onChange={handleInputChange}
              required
            ></textarea>
          </div>

          <div className="mb-3">
            <label htmlFor="item_name" className="form-label">
              Item Name
            </label>
            <input
              type="text"
              className="form-control"
              id="item_name"
              name="item_name"
              value={formData.item_name}
              onChange={handleInputChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="category" className="form-label">
              Category
            </label>
            <input
              type="text"
              className="form-control"
              id="category"
              name="category"
              value={formData.category}
              onChange={handleInputChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="price" className="form-label">
              Price
            </label>
            <input
              type="number"
              step="0.01"
              min="0"
              className="form-control"
              id="price"
              name="price"
              value={formData.price}
              onChange={handleInputChange}
              required
            />
          </div>

          <div className="mb-3">
            <label htmlFor="status" className="form-label">
              Status
            </label>
            <select
              className="form-select"
              id="status"
              name="status"
              value={formData.status}
              onChange={handleInputChange}
              required
            >
              <option value="Available">Available</option>
              
            </select>
          </div>

          <button type="submit" className="btn btn-success">
            Add Item for Sale
          </button>
        </form>
      )}
    </div>
  );
}
