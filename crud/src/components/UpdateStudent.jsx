
import React, { useEffect, useState } from 'react';
import { useForm, Controller } from 'react-hook-form';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import { Dropdown } from 'primereact/dropdown';
import { classNames } from 'primereact/utils';
import axios from 'axios';
import {useNavigate} from 'react-router-dom';
import { Navigate, useParams, useRoutes } from "react-router"


const UpdateStudent = () => {
    const [parents, setParents] = useState([]);
    const [student, setStudent] = useState({});
    const { id } = useParams()
    const navigate = useNavigate();
    const defaultValues = {
        name: '',
        lastName: '',
        email: ''
    }

    useEffect(() => {
        axios.get("http://localhost:8080/parent").then(res => {
            console.log(res);
            setParents(res.data.data);
        })
        axios.get(`http://localhost:8080/students/${id}`).then(res => {
            setStudent(res.data.data)
        })
    }, []);

    useEffect(() => {
        reset(student)
    }, [student])

    const { control, formState: { errors }, handleSubmit, reset } = useForm({ defaultValues });

    const onSubmit = (data) => {
        console.log(data)
        axios.post('http://localhost:8080/students', data).then(res => {
        });
        navigate('/');
        reset();
    };
    const getFormErrorMessage = (name) => {
        return errors[name] && <small className="p-error">{errors[name].message}</small>
    };

    return (
        <div className="form-demo">
            <div className="flex justify-content-center">
                <div className="card">
                    <h5 className="text-center">Register</h5>
                    <form onSubmit={handleSubmit(onSubmit)} className="p-fluid">
                        <div className="field">
                            <span className="p-float-label">
                                <Controller name="name" control={control} rules={{ required: 'Name is required.' }} render={({ field, fieldState }) => (
                                    <InputText id={field.name} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                                )} />
                                <label htmlFor="name" className={classNames({ 'p-error': errors.name })}>Name*</label>
                            </span>
                            {getFormErrorMessage('name')}
                        </div>
                        <div className="field">
                            <span className="p-float-label">
                                <Controller name="lastName" control={control} rules={{ required: 'lastName is required.' }} render={({ field, fieldState }) => (
                                    <InputText id={field.name} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                                )} />
                                <label htmlFor="lastName" className={classNames({ 'p-error': errors.lastName })}>lastName*</label>
                            </span>
                            {getFormErrorMessage('lastName')}
                        </div>
                        <div className="field">
                            <span className="p-float-label p-input-icon-right">
                                <i className="pi pi-envelope" />
                                <Controller name="email" control={control}
                                    rules={{ required: 'Email is required.', pattern: { value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i, message: 'Invalid email address. E.g. example@email.com' } }}
                                    render={({ field, fieldState }) => (
                                        <InputText id={field.name} {...field} className={classNames({ 'p-invalid': fieldState.invalid })} />
                                    )} />
                                <label htmlFor="email" className={classNames({ 'p-error': !!errors.email })}>Email*</label>
                            </span>
                            {getFormErrorMessage('email')}
                        </div>
                        <div className="field">
                            <span className="p-float-label">
                                <Controller name="parent" control={control} render={({ field }) => (
                                    <Dropdown id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} options={parents} optionLabel="name" />
                                )} />
                                <label htmlFor="parent">Parent</label>
                            </span>
                        </div>
                        <Button type="submit" label="Submit" className="mt-2" />
                    </form>
                </div>
            </div>
        </div>
    );
}
export default UpdateStudent
