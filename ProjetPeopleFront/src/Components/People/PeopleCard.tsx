import React from 'react'
import { useNavigate } from 'react-router-dom';


function PeopleCard( props : any ) {


  const navigate = useNavigate();
  const { people } = props;

  const goPeople = () => {
    navigate(`/detailPeople/${people.id}`);
  }


  return (

 
    <div className="max-w-sm mx-auto bg-white rounded-xl
    shadow-xl space-x-4 m-1" 
      onClick={goPeople}>
    <div className="p-4">
      <div>
        <div className=' text-2xl text-gray-700'>
            {people.firstname} {people.lastname}
        </div>
        <div className='  text-zinc-700'>
            <p className='mt-2'>
            EMAIL:{people.email}    </p>
            <p>
            PhoneNumber: {people.phone}
            </p>
        </div>
        </div>
        <div className=' text-right'>
            {people.country}
        </div>
        </div>
        </div>
   

  )
}

export default PeopleCard
