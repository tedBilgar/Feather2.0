new Vue({
    el: '#app',
    data() {
        return {
            info: null
        };
    },
    mounted() {
        axios
            .get('http://localhost:9000/rest/desk')
            .then(response => (this.info = response.data));
    }
});