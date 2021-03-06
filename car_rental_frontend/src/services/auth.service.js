import axios from 'axios';
class AuthService {
    login(user) {
        return axios.post('localhost:8080/login', {
            username: user.username,
            password: user.password
        })
            .then(response => {
                if (response.data) {
                    localStorage.setItem('user', JSON.stringify(response.data));
                }
                return response.data;
            });
    }
    logout() {
        localStorage.removeItem('user');
    }
    register(user) {
        return axios.post('localhost:8080/register', {
            username: user.username,
            password: user.password,
            email: user.email,
        });
    }
}

export default new AuthService();