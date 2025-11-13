<!--
  *  layout 多种模式
  *
-->
<template>
  <!--左侧菜单 模式-->
  <SideLayout v-if="layout === LAYOUT_ENUM.SIDE.value" />
  <!--左侧展开菜单 模式-->
  <SideExpandLayout v-if="layout === LAYOUT_ENUM.SIDE_EXPAND.value" />
  <!--顶部菜单 模式-->
  <TopLayout v-if="layout === LAYOUT_ENUM.TOP.value" />
  <!--定期修改密码-->
  <RegularChangePasswordModal />
  <!--顶部展开 模式-->
  <TopExpandLayout v-if="layout === LAYOUT_ENUM.TOP_EXPAND.value" />
</template>
<script setup lang="ts">
  import { computed } from 'vue';
  import { LAYOUT_ENUM } from '/@/constants/layout-const';
  import SideExpandLayout from './side-expand-layout.vue';
  import TopExpandLayout from './top-expand-layout.vue';
  import SideLayout from './side-layout.vue';
  import TopLayout from './top-layout.vue';
  import { useAppConfigStore } from '/@/store/modules/system/app-config';
  import RegularChangePasswordModal from './components/change-password/regular-change-password-modal.vue';

  const layout = computed(() => useAppConfigStore().$state.layout);
</script>

