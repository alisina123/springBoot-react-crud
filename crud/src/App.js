
import './App.css';
import ListStudent from './components/ListStudent';
import RegisterStudent from './components/RegisterStudent';
import StudentDetails from './components/StudentDetails';
import UpdateStudent from './components/UpdateStudent';
import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "/node_modules/primeflex/primeflex.css"; 

import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route index element="/" element={<ListStudent />}/>
      <Route path='/register' element={<RegisterStudent />} />
      <Route path='/studentDetails/:id' element={<StudentDetails />} />
      <Route path='/updateStudent/:id' element={<UpdateStudent />} />
    </Routes>
    
  </BrowserRouter>
  );
}

export default App;
