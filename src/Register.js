import {Fragment, useState} from 'react';
import axios from 'axios';
function Register(){

     const[user, setUser] = useState({

        username : '',
        password : '',
        email : ''
     })
     const updateState = (event) => {
        var value = event.target.value;
        var name = event.target.name;
          setUser({...user, [name] : value});
     }
     const register = (event) =>{
        event.preventDefault();
        console.log(user);

        axios.post("http://localhost:9091/user/register", user).then(
            response =>{
                console.log(response)
            },
            error => {
                 console.log(error)
            }
        )

     }

     return (
        <Fragment>

            <form>
                <input placeholder='username here' onChange={updateState} type="text" name="username"></input> <br></br> <br></br>
                 <input placeholder='password here' onChange={updateState} type="text" name="password"></input> <br></br> <br></br>
                  <input placeholder='email here' onChange={updateState} type="text" name="email"></input> <br></br>

                  <button onClick={register}>Register</button>


            </form>
        </Fragment>
     )

}
export default Register