import React from "react";
import ReactDOM from "react-dom/client";
import axios from "axios";

class Customer extends React.Component {
    state = {
        customers: [],
        count: 0
    }

    componentDidMount() {
        axios.get('http://localhost:8080/get/customers')
            .then(res => {
                const customers = res.data;
                this.setState({ customers });
                var count = 0;
                this.setState({ count })
            })
    }

    render() {
        return(
            <div className="table-responsive">
                <table className="table table-hover table-bordered table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Customer ID</th>
                            <th scope="col">Company Name</th>
                            <th scope="col">Customer Name</th>
                        </tr>
                    </thead>
                    <tbody>

                        { this.state.customers.map((customer) => 
                            <tr key={customer.customerId}>
                                <th scope="row">{customer.customerId}</th>
                                <td>{customer.companyName}</td>
                                <td>{customer.contactName}</td>
                            </tr>
                        )}

                        
                    </tbody>
                </table>
            </div>
        )
    }
}


export default Customer;