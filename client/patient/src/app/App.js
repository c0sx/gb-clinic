import { Route, Switch, Redirect } from "react-router-dom";

import { Initialize } from "../initialize/Initialize";
import { Signin } from "../signin/Signin";
import { Signup } from "../signup/Signup";
import { Appointments } from "../appointments/Appointments";

export const App = () => {
    return (
        <Switch>
            <Route exact={true} path={"/patient"} component={Initialize}/>
            <Route path={"/patient/sign-in"} component={Signin} />
            <Route path={"/patient/sign-up"} component={Signup} />
            <Route path={"/patient/appointments"} component={Appointments}/>
            <Redirect to={"/patient"} />
        </Switch>
    )
}
