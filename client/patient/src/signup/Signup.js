import React, { useState } from "react";
import { useDispatch } from "react-redux";
import {signUpAsync} from "../saga/signUpAsync";

export const Signup = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [surname, setSurname] = useState("");
    const [name, setName] = useState("");
    const [dateOfBirth, setDateOfBirth] = useState("");

    const dispatch = useDispatch();

    const onSubmitHandler = e => {
        e.preventDefault();
        e.stopPropagation();

        dispatch(signUpAsync({
            username,
            password,
            user: {
                surname,
                name,
                dateOfBirth
            }
        }))
    }

    return (
        <div>
            <form onSubmit={onSubmitHandler}>
                <div>
                    <label>Логин</label>
                    <input type={"text"} value={username} onChange={e => setUsername(e.target.value)}/>
                </div>
                <div>
                    <label>Пароль</label>
                    <input type={"password"} value={password} onChange={e => setPassword(e.target.value)}/>
                </div>
                <div>
                    <label>Фамилия</label>
                    <input type={"text"} value={surname} onChange={e => setSurname(e.target.value)}/>
                </div>
                <div>
                    <label>Имя</label>
                    <input type={"text"} value={name} onChange={e => setName(e.target.value)}/>
                </div>
                <div>
                    <label>Дата рождения</label>
                    <input type={"date"} value={dateOfBirth} onChange={e => setDateOfBirth(e.target.value)}/>
                </div>
                <div>
                    <input type={"submit"} value={"Зарегистрироваться"}/>
                </div>
            </form>
        </div>
    )
}
