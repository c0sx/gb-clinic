import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { Link } from "react-router-dom";

import { signInAsync } from "../saga/signInAsync";

export const Signin = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const dispatch = useDispatch();

    const onSubmitHandler = e => {
        e.preventDefault();
        e.stopPropagation();

        dispatch(signInAsync({ username, password }))
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
                    <input type={"submit"} value={"Вход"}/>
                </div>
            </form>
            <Link to={"/patient/sign-up"}>Регистрация</Link>
        </div>
    );
};
