import { createWebHistory, createRouter } from "vue-router";
import Home from "@/components/Home";
import AllCars from "@/components/AllCars";
import About from "@/components/About";
import Rules from "@/components/Rules";
const routes = [
    {
        path: "/",
        component: Home,
    },
    {
        path: "/allcars",
        component: AllCars
    },
    {
        path: "/about",
        component: About
    },
    {
        path: "/rules",
        component: Rules
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})
export default router;