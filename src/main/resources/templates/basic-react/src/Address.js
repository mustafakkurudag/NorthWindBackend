import React from "react";
import ReactDOM from "react-dom/client";
import axios from "axios";

class Address extends React.Component {

    state = {
        addresses: [],
        city:'',
        district: '',
        neighborhood: '',
        street: ''   
    }

    showAddresses = event => {
        event.preventDefault();

        axios.get('http://localhost:8080/address/get/all')
            .then(res => {
                const addresses = res.data;
                this.setState({ addresses });
            })
    }

    handleChangeCity = e => {
        this.setState({ city:e.target.value });
    }

    handleChangeDistrict = e => {
        this.setState({ district:e.target.value});
    }

    handleChangeNeighborhood = e => {
        this.setState({ neighborhood:e.target.value });
    }

    handleChangeStreet = e => {
        this.setState({ street:e.target.value});
    }

    handleSubmit = event => {
        event.preventDefault();

        console.log(this.state.city);
        console.log(this.state.district);

        const address = {
            city: this.state.city,
            district: this.state.district,
            neighborhood: this.state.neighborhood,
            street: this.state.street
        };

        //this.setState({address: address});
        

        axios.post(`http://localhost:8080/address/add`, address)
            .then(res => {
                console.log("veri gönderiliyor...");
                console.log(res);
                console.log(res.data);
        })
        
    }


    render() {
        return(
            <div className="content">
            <form onSubmit={this.handleSubmit} >
                <div className="form-group">
                    <label htmlFor="city">İl:</label>
                    <input type="text" name="city" className="form-control" 
                    onChange={this.handleChangeCity} 
                    placeholder="Yaşadığınız il" />
                </div>
                <div className="form-group">
                    <label htmlFor="district">İlçe:</label>
                    <input type="text" name="district" className="form-control" 
                    onChange={this.handleChangeDistrict} 
                    placeholder="Yaşadığınız ilçe" />
                </div>
                <div className="form-group">
                    <label htmlFor="neighborhood">Mahalle:</label>
                    <input type="text" name="neighborhood" className="form-control" 
                        onChange={this.handleChangeNeighborhood} 
                        placeholder="Yaşadığınız mahalle" />
                </div>
                <div className="form-group">
                    <label htmlFor="street">Sokak/Cadde:</label>
                    <input type="text" name="street" className="form-control"
                        onChange={this.handleChangeStreet}
                         placeholder="Yaşadığınız sokak" />
        </div>
        
                <button type="submit" className="btn btn-primary">Kaydet</button>
            </form>
            <div className="table-responsive">
                <table className="table table-hover table-bordered table-striped">
                    <thead>
                    <tr>
                        <th scope="col">City</th>
                        <th scope="col">District</th>
                        <th scope="col">Neighborhood</th>
                        <th scope="col">Street</th>
                    </tr>
                    </thead>
                    <tbody>
                        { this.state.addresses.map((addr) => 
                        <tr key={addr.city}>
                            <td>{addr.city}</td>
                            <td>{addr.district}</td>
                            <td>{addr.neighborhood}</td>
                            <td>{addr.street}</td>
                        </tr>
                        )}
                    </tbody>
                </table>
                <form onSubmit={this.showAddresses}>
                    <button type="submit" className="btn btn-success">Göster</button>
                </form>
            </div>
            </div>
        )
    }
}


export default Address;