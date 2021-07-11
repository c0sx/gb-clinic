import { Route, Switch, Redirect } from "react-router-dom";

import { Initialize } from "../initialize/Initialize";
import { Signin } from "../signin/Signin";
import { Appointments } from "../appointments/Appointments";

export const App = () => {
    return (
        <Switch>
            <Route exact={true} path={"/"} component={Initialize}/>
            <Route path={"/sign-in"} component={Signin} />
            <Route path={"/appointments"} component={Appointments}/>
            <Redirect to={"/"} />
        </Switch>
    )
}
