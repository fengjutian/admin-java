<!--
  * 枚举 radio
  *
-->
<template>
  <radio-group @change="handleChange">
    <label v-for="item in $smartEnumPlugin.getValueDescList(props.enumName)" :key="item.value" class="smart-margin-right10">
      <radio :value="item.value + ''" :checked="item.value === modelValue">{{ item.desc }}</radio>
    </label>
  </radio-group>
</template>

<script setup>
  import { ref, watch } from 'vue';

  const props = defineProps({
    enumName: String,
    modelValue: [Number, String],
  });

  const emit = defineEmits(['update:modelValue', 'change']);

  const selectValue = ref(props.modelValue);

  watch(
    () => props.modelValue,
    (newValue) => {
      selectValue.value = newValue;
    }
  );

  function handleChange(e) {
    emit('update:modelValue', e.detail.value);
    emit('change', e.detail.value);
  }
</script>

