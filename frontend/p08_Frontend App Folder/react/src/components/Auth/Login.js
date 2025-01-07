import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { login } from "../../redux/slices/authSlice";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const validateInput = () => {
    if (!email || !password) {
      setErrorMessage("Both email and password are required");
      return false;
    }
    return true;
  };

  const handleLogin = async (e) => {
    e.preventDefault();

    // Validate inputs
    if (!validateInput()) return;

    try {
      const response = await axios.post("http://localhost:9000/login", {
        email,
        password,
      });

      console.log("API Response:", response.data); // Debug the response
      const { user, role } = response.data;

      console.log("Role Name:", role.roleName); // Debug roleName

      dispatch(login({ user, role }));

      switch (role.roleName) {
        case "Admin":
          navigate("/dashboard/admin");
          break;
        case "Customer":
          navigate("/dashboard/customer");
          break;
        case "Agency":
          navigate("/dashboard/owner");
          break;
        default:
          navigate("/");
          break;
      }
    } catch (error) {
      if (error.response) {
        const errorData = error.response.data;
        setErrorMessage(
          error.response.status === 401
            ? errorData.message === "Invalid password"
              ? "Incorrect password"
              : errorData.message === "User not found"
              ? "Username not found"
              : "Invalid email or password"
            : "An error occurred, please try again"
        );
      } else {
        setErrorMessage("Network error, please check your connection");
      }
    }
  };

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card shadow">
            <div className="card-body">
              <h2 className="card-title text-center">Login</h2>
              {errorMessage && (
                <div className="alert alert-danger text-center">
                  {errorMessage}
                </div>
              )}
              <form onSubmit={handleLogin}>
                <div className="mb-3">
                  <label htmlFor="email" className="form-label">
                    Email
                  </label>
                  <input
                    type="email"
                    className="form-control"
                    id="email"
                    placeholder="Your Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    style={{ transition: "all 0.3s ease-in-out" }}
                    onFocus={(e) => (e.target.placeholder = "")}
                    onBlur={(e) => (e.target.placeholder = "Your Email")}
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="password" className="form-label">
                    Password
                  </label>
                  <input
                    type="password"
                    className="form-control"
                    id="password"
                    placeholder="Your Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    style={{ transition: "all 0.3s ease-in-out" }}
                    onFocus={(e) => (e.target.placeholder = "")}
                    onBlur={(e) => (e.target.placeholder = "Your Password")}
                  />
                </div>
                <button type="submit" className="btn btn-primary w-100">
                  Login
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
