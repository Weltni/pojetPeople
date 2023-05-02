import React from 'react'
import { Route, Routes } from 'react-router-dom'
import PeopleScreen from '../Pages/PeopleScreen'
import PeopleDetail from '../Pages/PeopleDetail'
import PeopleAdd from '../Pages/PeopleAdd'


function Navigation() {
  return (
    <Routes>
   <Route path='/' element={<PeopleScreen/>}/>
   <Route path='/detailPeople/:id' element={<PeopleDetail/>}/>
   <Route path='/people/add' element={<PeopleAdd/>}/>
    </Routes>
 
      )
}

export default Navigation
