import React from 'react'
import { useNavigate } from 'react-router-dom';

function Header() {
    
  const navigate = useNavigate();
  
  return (
    <div>
      <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
      onClick={() => navigate(`/people/add`)}
>
Add</button>
    </div>
  )
}

export default Header
