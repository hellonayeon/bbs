import { createContext, useState } from "react";

export const AuthContext = createContext();

function AuthProvider({ children }) {

	const [auth, setAuth] = useState(localStorage.getItem("id"));

	const value = {auth, setAuth };

	return (
		<AuthContext.Provider value = {value}>
			{children}
		</AuthContext.Provider>
	);

}

export default AuthProvider;