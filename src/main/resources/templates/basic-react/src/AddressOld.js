import React from "react";
import { useState, useEffect } from "react";
import axios from "axios";

const API_ADDRESS_SERVICE_URL = "http://localhost:8080/address";


//@TODO postlu şeklini kaydet...
function Address() {
    const[address, setAddress] = useState([])

    const[city, setCity] = useState('')
    const[district, setDistrict] = useState('')
    const[neighborhood, setNeighborhood] = useState('')
    const[street, setStreet] = useState('')

    useEffect(() => {
        axios.get('http://localhost:8080/get/all')
            .then(res => {
                setAddress(res.data)
            }, [])

        const postData = (e) => {
            e.preventDefault();
            axios.post(API_ADDRESS_SERVICE_URL + '/add', {
                city,
                district,
                neighborhood,
                street
            }).then(res => {
                    console.log("veri gönderiliyor...");
                })
        }
    }
    );
    
       

  const arr = address.map((addr) => {
    return (
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
                        <td>{addr.city}</td>
                        <td>{addr.district}</td>
                        <td>{addr.neighborhood}</td>
                        <td>{addr.street}</td>
                </tbody>
            </table>
        </div>
        ) }
        
        )

    
                    
 return(
    <div className="App">

            <form>
            <div className="form-group">
               <label htmlFor="city">İl:</label>
               <input type="text" name={city} className="form-control" onChange={(e) => setCity(e.target.value)} aria-describedby="cityHelp" placeholder="Yaşadığınız il" />
            </div>
            <div className="form-group">
               <label htmlFor="district">İlçe:</label>
               <input type="text" name={district} className="form-control" onChange={(e) => setDistrict(e.target.value)}  aria-describedby="districtHelp" placeholder="Yaşadığınız ilçe" />
            </div>
            <div className="form-group">
               <label htmlFor="neighborhood">Mahalle:</label>
               <input type="text" name={neighborhood} className="form-control" onChange={(e) => setNeighborhood(e.target.value)} aria-describedby="neighborHelp" placeholder="Yaşadığınız mahalle" />
            </div>
            <div className="form-group">
               <label htmlFor="street">Sokak/Cadde:</label>
               <input type="text" name={street} className="form-control" onChange={(e) => setStreet(e.target.value)} aria-describedby="streetHelp" placeholder="Yaşadığınız sokak" />
            </div>
            <button type="submit" className="btn btn-primary">Kaydet</button>
            </form>
            </div>
        )
 }

 export default AddressOld;