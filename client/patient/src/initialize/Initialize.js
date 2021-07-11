import React, { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom";
import { useSelector } from "react-redux";

import { getInfo } from "../api/getInfo";
import { signOut } from "../api/signOut";
import { selectPatientId } from "../store/patient/selectors";

export const Initialize = () => {
    const [isGuest, setGuest] = useState(false);
    const patientId = useSelector(selectPatientId);
    const history = useHistory();

    useEffect(() => {
        if (patientId) {
            history.replace("/patient/appointments")
        }
    }, [history, patientId])

    useEffect(() => {
        (async () => {
            try {
                await getInfo()
                history.replace("/patient/appointments")
            }
            catch (e) {
                setGuest(true);
            }
        })();
    }, [history]);

    return (
        <>
            <div>Загрузка...</div>
            {isGuest ? <Link to={"/patient/sign-in"}>Вход</Link> : null}
            {isGuest ? <Link to={"/patient/sign-up"}>Регистрация</Link> : null}
            {patientId ? <a href={"/patient/sign-in"} onClick={signOut}>Выход</a> : null}
        </>
    )
}
