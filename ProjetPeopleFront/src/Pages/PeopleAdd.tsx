import React from 'react'
import * as Yup from 'yup';
import {Formik , Form, Field} from 'formik';
import Header from '../Components/Header';

function PeopleAdd() {

    const ValidSchema = Yup.object().shape ({
        firstname: Yup.string()
        .min(2,'Too short')
        .max(50, 'Too Long !')
        .required('Required'),
        lastname: Yup.string()
        .min(2,'Too short')
        .max(50, 'Too Long !')
        .required('Required'),
        email: Yup.string().email('invalid email')
        .min(10, 'TooShort')
        .max(100,'Too Long!')
        .required('Required'),
        phone : Yup.string()
        .min(8, 'TooShort')
        .max(20,'Too Long!')
        .required('Required'),
        country :   Yup.string()
        .min(6, 'TooShort')
        .max(50,'Too Long!')
        .required('Required')
    });
  return (
    <div>
        <Header/>
        
    </div>
  )
}

export default PeopleAdd
