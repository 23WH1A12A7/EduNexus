import React, { useEffect, useState } from 'react';
import '../styles/ItemExchange.css';

const ItemExchange = () => {
  const [items, setItems] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch('http://localhost:8080/api/items/all')  // Add your backend base URL and endpoint
      .then(res => {
        if (!res.ok) throw new Error("Failed to fetch items");
        return res.json();
      })
      .then(data => {
        setItems(data);
        setLoading(false);
      })
      .catch(err => {
        console.error("Error fetching items:", err);
        setLoading(false);
      });
  }, []);

  if (loading) return <p>Loading items...</p>;

  if (items.length === 0) return <p>No items available for exchange.</p>;

  return (
    <div className="item-exchange">
      <h1>Item Exchange</h1>
      <ul className="items-list">
        {items.map(item => (
          <li key={item.id} className="item-card">
            <h3>{item.name}</h3>
            <p>{item.description}</p>
            <p><strong>Owner ID:</strong> {item.userId}</p>
            {/* Placeholder for actions like "Request Exchange" */}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ItemExchange;
