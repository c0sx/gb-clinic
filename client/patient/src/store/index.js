import { configureStore, getDefaultMiddleware } from "@reduxjs/toolkit";
import createSagaMiddleware from "redux-saga";

import { sagas } from "./sagas";
import { reducer } from "./reducer";

const sagaMiddleware = createSagaMiddleware();
const middleware = [...getDefaultMiddleware(), sagaMiddleware];

export const store = configureStore({
    reducer,
    middleware
});

sagaMiddleware.run(sagas);
