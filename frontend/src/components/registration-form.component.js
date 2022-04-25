import React, {useState} from 'react';
import './registration-form.style.css'

function RegistrationForm() {
    const [userName, setUserName] = useState(null);
    const [userLogin, setUserLogin] = useState(null);
    const [email, setEmail] = useState(null);
    const [password,setPassword] = useState(null);
    const [confirmPassword,setConfirmPassword] = useState(null);
    
    const handleInputChange = (e) => {
        const {id , value} = e.target;
        if(id === "userName"){
            setUserName(value);
        }
        if(id === "userLogin"){
            setUserLogin(value);
        }
        if(id === "email"){
            setEmail(value);
        }
        if(id === "password"){
            setPassword(value);
        }
        if(id === "confirmPassword"){
            setConfirmPassword(value);
        }

    }

    const handleSubmit  = () => {
        console.log(userName, userLogin, email, password, confirmPassword);
    }


    return(
      <div className="form">
          <div className="form-body">
              <div className="username">
                  <label className="form__label" for="userName">Username </label>
                  <input className="form__input" type="text" value={userName} onChange = {(e) => handleInputChange(e)} id="userName" placeholder="Your name..."/>
              </div>
              <div className="userlogin">
                  <label className="form__label" for="userLogin">Login </label>
                  <input className="form__input" type="text" value={userLogin} onChange = {(e) => handleInputChange(e)} id="userLogin" placeholder="Login..."/>
              </div>
              <div className="email">
                  <label className="form__label" for="email">Email </label>
                  <input  type="email" value={email} onChange = {(e) => handleInputChange(e)} id="email" className="form__input" placeholder="Email..."/>
              </div>
              <div className="password">
                  <label className="form__label" for="password">Password </label>
                  <input className="form__input" value={password} onChange = {(e) => handleInputChange(e)} type="password"  id="password" placeholder=""/>
              </div>
              <div className="confirm-password">
                  <label className="form__label" for="confirmPassword">Confirm Password </label>
                  <input className="form__input" value={confirmPassword} onChange = {(e) => handleInputChange(e)} type="password" id="confirmPassword" placeholder=""/>
              </div>
          </div>
          <div class="footer">
              <button onClick={()=>handleSubmit()} type="submit" class="btn">Sign up</button>
          </div>
      </div>      
    )       
}
export default RegistrationForm;