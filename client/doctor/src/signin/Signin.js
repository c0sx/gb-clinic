import React, { useState } from "react";
import { useDispatch } from "react-redux";

import { signInDoctorAsync } from "../saga/signInDoctorAsync";

export const Signin = () => {
    const [username, setUsername] = useState("doctor");
    const [password, setPassword] = useState("12345");

    const dispatch = useDispatch();

    const onSubmitHandler = e => {
        e.preventDefault();
        e.stopPropagation();

        dispatch(signInDoctorAsync({ username, password }))
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
        </div>
    );
};
