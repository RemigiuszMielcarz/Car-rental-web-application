import { createWebHistory, createRouter } from "vue-router";
import Home from "@/components/Home";
import AllCars from "@/components/AllCars";
import About from "@/components/About";
import Rules from "@/components/Rules";
import Power from "@/components/Power";
import Electric from "@/components/Electric";
import Legendary from "@/components/Legendary";
import Luxury from "@/components/Luxury";
import Design from "@/components/Design";
import Dynamic from "@/components/Dynamic";
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
    },
    {
        path: "/power",
        component: Power
    },
    {
        path: "/electric",
        component: Electric
    },
    {
        path: "/legendary",
        component: Legendary
    },
    {
        path: "/luxury",
        component: Luxury
    },
    {
        path: "/design",
        component: Design
    },
    {
        path: "/dynamic",
        component: Dynamic
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})
export default router;