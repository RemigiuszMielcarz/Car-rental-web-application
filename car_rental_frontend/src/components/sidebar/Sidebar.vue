<template>
  <div class="sidebar" :style="{ width: sidebarWidth }">

    <img src="../../plugins/images/logo.png">

    <SidebarLink to="/" icon="fas fa-home">Home</SidebarLink>
    <SidebarLink to="/allcars" icon="fas fa-car">All cars</SidebarLink>
    <SidebarLink to="/rules" icon="fa-solid fa-handshake-angle">Rules</SidebarLink>
    <SidebarLink to="/about" icon="fa-solid fa-circle-info">About us</SidebarLink>

    <span
        class="collapse-icon"
        :class="{ 'rotate-180': collapsed }"
        @click="toggleSidebar"
    >
      <i class="fas fa-angle-double-left" />
    </span>
  </div>
</template>

<script>
import SidebarLink from "@/components/sidebar/SidebarLink";
import { collapsed, toggleSidebar, sidebarWidth } from "./state";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Sidebar",
  props: {},
  components: { SidebarLink },
  setup() {
    return { collapsed, toggleSidebar, sidebarWidth }
  }
}
</script>

<style>
:root {
  --sidebar-bg-color: #8f8f8f;
  --sidebar-item-hover: #212121;
  --sidebar-item-active: #000000;
}
</style>

<style scoped>
.sidebar {
  color: #ffffff;
  background-color: var(--sidebar-bg-color);
  float: left;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  bottom: 0;
  padding: 0.5em;
  transition: 0.3s ease;
  display: flex;
  flex-direction: column;
}
.sidebar h1 {
  height: 4em;
}
.collapse-icon {
  position: absolute;
  bottom: 0;
  padding: 0.75em;
  color: rgba(255, 255, 255, 0.7);
  transition: 0.2s linear;
}
.rotate-180 {
  transform: rotate(180deg);
  transition: 0.2s linear;
}
</style>