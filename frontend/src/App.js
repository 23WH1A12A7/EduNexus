import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Homepage from './auth/Homepage';
import Login from './auth/Login';
import Register from './auth/Register';
import Dashboard from './dashboard/Dashboard'; // ✅ import

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Homepage />} />
        <Route path="/" element={<Navigate to="/login" replace />} /> {/* Redirect / to /login */}
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
        <Route path="/dashboard/*" element={<Dashboard />} /> {/* ✅ this line */}
        

      </Routes>
    </Router>
  );
}

export default App;
