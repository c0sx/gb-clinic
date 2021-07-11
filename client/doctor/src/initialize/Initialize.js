import React, { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom";
import { useSelector } from "react-redux";

import { getInfo } from "../api/getInfo";
import { signOut } from "../api/signout";
import { selectDoctorId } from "../store/doctor/selectors";

export const Initialize = () => {
    const [isGuest, setGuest] = useState(false);
    const doctorId = useSelector(selectDoctorId);
    const history = useHistory();

    useEffect(() => {
        if (doctorId) {
            history.replace("/appointments")
        }
    }, [history, doctorId])

    useEffect(() => {
        (async () => {
            try {
                await getInfo()
                history.replace("/appointments")
            }
            catch (e) {
                setGuest(true);
            }
        })();
    }, [history]);

    return (
        <>
            <div>Загрузка...</div>
            {isGuest ? <Link to={"/sign-in"}>Вход</Link> : null}
            {doctorId ? <a href={"/sign-in"} onClick={signOut}>Выход</a> : null}
        </>
    )
}
