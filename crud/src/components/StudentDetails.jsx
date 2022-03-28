import axios from "axios"
import React, { useEffect, useState } from "react"
import { useParams } from "react-router"
const StudentDetails = () => {

    const { id } = useParams()
    const [obj, setObj] = useState({})

    useEffect(() => {
        axios.get(`http://localhost:8080/students/${id}`).then(res => {
            setObj(res.data.data)
        });
    }, [])

    return <>

        <div className="container">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">LastName</th>
                        <th scope="col">Email</th>
                        <th scope="col">Parent</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">{obj.id}</th>
                        <td>{obj.name}</td>
                        <td>{obj.lastName}</td>
                        <td>{obj.email}</td>
                        <td>{obj.parent ? obj.parent.name : ''}</td>
                        
                    </tr>
                </tbody>
            </table>
        </div>
    </>
}
export default StudentDetails