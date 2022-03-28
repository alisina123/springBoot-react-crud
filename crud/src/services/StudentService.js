import axios from "axios";

const Base_url="localhost:8080/home/getAllParent";

class StudentService{

    getStudets(){
        return axios.get(Base_url);
    }
    
}
export default new StudentService();