import React, { Component } from "react";
import { Switch, Route, Link, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import SongsList from "./components/songs-list.component";
import RegistrationForm from "./components/registration-form.component";


function App() {
    return (
      <div>
        <nav className="navbar navbar-expand">
          <a href="/home" className="navbar-brand">
            SoTra
          </a>
          <div className="navbar-nav">
            <li className="nav-item">
              <a href="/registration" className="btn btn-outline-light btn-lg enabled" role="button" aria-disabled="false">
                Sign in
              </a>
            </li>
            <li className="nav-item">
              <a href="/authorization" className="btn btn-outline-light btn-lg enabled" role="button" aria-disabled="false">
                Sign up
              </a>
            </li>
            <li className="nav-item">
              <a class="nav-link" href="/home">
                Home
              </a>
            </li>
          </div>
        </nav>
        <div className="container mt-3">
          <Routes>
            <Route index element={<SongsList />} />
            <Route path="/home" element={<SongsList />} />
            <Route path="/registration" element={<RegistrationForm />} />
          </Routes>
        </div>
      </div>
    );
  }
export default App;