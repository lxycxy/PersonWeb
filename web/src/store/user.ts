import {defineStore} from "pinia";
import router from "@/router";


export const useUserStore = defineStore('user', {
    persist: true,
    state: () => {
        return{
            id:'',
            username:'',
            photo:'',
            token:'',
        };
    },
    getters:{
        getToken: state => {
            return state.token;
        },
        getId: state => {
            return state.id
        },
        getUsername: state => {
            return state.username
        },
        getPhoto: state => {
            return state.photo
        }
    },
    actions: {
        logout() {
            this.id = '';
            this.token = '';
            this.username = '';
            this.photo = '';
            localStorage.removeItem("jwt_token");
            router.push('/login');
        }

    }
})