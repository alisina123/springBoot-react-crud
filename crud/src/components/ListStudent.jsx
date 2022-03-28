import axios from 'axios';
import React, { useEffect, useState, useRef, Component } from 'react'
import { Link } from "react-router-dom";
import { Toast } from 'primereact/toast';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column'

export const ListStudent = () => {

    const [students, setStudents] = useState([]);
    const toast = useRef(null);
    useEffect(() => {

        axios.get("http://localhost:8080/students").then(response => {
            console.log(response.data);
            setStudents(response.data.data);
        });
        axios.delete("http://localhost:8080/students").then(response => {
            console.log(response);
        });
    }, []);
    const deleteStudent = (id) => {
        toast.current.show({ severity: 'success', summary: 'Success Message', detail: 'Message Content', life: 3000 });
        axios.delete(`http://localhost:8080/students/${id}`).then(res => {

            setStudents(students.filter(function (value, index, arr) { return value.id != id; }))
        })
    }

    const detailsBody = (rowData) => {
        console.log(rowData)
        return <Link to={`/studentDetails/${rowData.id}`}>Details</Link>
    }
    const editBody = (rowData) => {
        console.log(rowData)
        return <Link to={`/UpdateStudent/${rowData.id}`}>Update</Link>
    }
    const deleteBody = (rowData) => {
        console.log(rowData)
         return <button icon="fa fa-trash" onClick={() => deleteStudent(rowData.id)} >Delete</button>
    }
    return (
        <div className="container">
             <Link to="/register">Register</Link>
            <Toast ref={toast} />
            <div>
                <div className="card">
                    <DataTable value={students} responsiveLayout="scroll">
                        <Column field="lastName" header="LastName"/>
                        <Column field="name" header="Name"/>
                        <Column field="parent.name" header="Parent"/>
                        <Column field="email" header="Email"/>
                        <Column header="Detials" body={detailsBody}/>
                        <Column header="Edit" body={editBody}/>
                        <Column header="Delete" body={deleteBody}/>
                    </DataTable>
                </div>
            </div>
        </div>
    );


}
export default ListStudent