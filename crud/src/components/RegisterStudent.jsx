
import React, { useEffect, useState ,useRef } from 'react';
import { useForm, Controller } from 'react-hook-form';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import { Dropdown } from 'primereact/dropdown';
import { Calendar } from 'primereact/calendar';
import { Password } from 'primereact/password';
import { Checkbox } from 'primereact/checkbox';
import { Dialog } from 'primereact/dialog';
import { Divider } from 'primereact/divider';
import { classNames } from 'primereact/utils'
import {useNavigate} from 'react-router-dom';
import { Toast } from 'primereact/toast';
import axios from 'axios';

const RegisterStudent = () => {
    const [showMessage, setShowMessage] = useState(false);
    const [formData, setFormData, students, setStudent] = useState({});
    const [parents,setParents]=useState([]);
    const navigate = useNavigate();
    const toast = useRef(null);
    const showSuccess = () => {
        toast.current.show({severity:'success', summary: 'Success Message', detail:'Message Content', life: 3000});
    }
    const defaultValues = {
        name: '',
        lastName: '',
        email: '',
        accept: false
    }

    useEffect(() => {
        axios.get("http://localhost:8080/parent").then(response => {
            console.log(response.data.data);
            setParents(response.data.data);
        });

    }, []);
    const { control, formState: { errors }, handleSubmit, reset } = useForm({ defaultValues });
    const onSubmit = (data) => {
        axios.post("http://localhost:8080/students", data).then(response => {
            console.log(response.data);
            

        });
        reset();
        navigate('/')
        toast.current.show({severity: 'success', summary: 'Success Message', detail: 'Order submitted'});

    };
    const getFormErrorMessage = (name) => {
        return errors[name] && <small className="p-error">{errors[name].message}</small>
    };
    const dialogFooter = <div className="flex justify-content-center"><Button label="OK" className="p-button-text" autoFocus onClick={() => setShowMessage(false)} /></div>;
   
    return (
        <div className="form-demo">
         
            <div className="flex justify-content-center">
                <div className="card">
                    <h5 className="text-center">Update</h5>
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
                                <Controller name="lastName" control={control} rules={{ required: 'LastName is required.' }} render={({ field, fieldState }) => (
                                    <InputText id={field.lastName} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                                )} />
                                <label htmlFor="lastName" className={classNames({ 'p-error': errors.lastName })}>lastName*</label>
                            </span>
                            {getFormErrorMessage('name')}
                        </div>
                        <div className="field">
                            <span className="p-float-label p-input-icon-right">
                                <i className="pi pi-envelope" />
                                <Controller name="email" control={control}
                                    rules={{ required: 'Email is required.', pattern: { value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i, message: 'Invalid email address. E.g. example@email.com' } }}
                                    render={({ field, fieldState }) => (
                                        <InputText id={field.email} {...field} className={classNames({ 'p-invalid': fieldState.invalid })} />
                                    )} />
                                <label htmlFor="email" className={classNames({ 'p-error': !!errors.email })}>Email*</label>
                            </span>
                            {getFormErrorMessage('email')}
                        </div>
                        <Controller name="parent" control={control} render={({ field }) => (
                                    <Dropdown id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} options={parents} optionLabel="name" />
                        )} />
                        <div className="field-checkbox">
                            <Controller name="accept" control={control} rules={{ required: true }} render={({ field, fieldState }) => (
                                <Checkbox inputId={field.name} onChange={(e) => field.onChange(e.checked)} checked={field.value} className={classNames({ 'p-invalid': fieldState.invalid })} />
                            )} />
                            <label htmlFor="accept" className={classNames({ 'p-error': errors.accept })}>I agree to the terms and conditions*</label>
                        </div>

                        <Button type="submit" label="Submit" className="mt-2" />
                    </form>
                </div>
            </div>
        </div>
    );
}

export default RegisterStudent
