<script setup>
import { ref } from 'vue';


// const onMounted = onMounted({

// });

const data = ref({
	hello: "hello world",
});

</script>

<template>
	<div>
		<h1>Test {{ data.hello }}</h1>
	</div>
</template>

<style lang="scss" scoped></style>
