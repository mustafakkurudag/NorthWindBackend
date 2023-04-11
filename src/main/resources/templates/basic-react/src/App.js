import React from "react";
import ReactDOM from "react-dom/client";
import Customer from "./Customer";
import Address from "./Address";


class App extends React.Component {
    render() {
        return (
            <div className="container">
                <div className="row">
                    <div className="col-sm">
                        <Address />
                    </div>
                </div>
            </div>
        )
    }
}

export default App;