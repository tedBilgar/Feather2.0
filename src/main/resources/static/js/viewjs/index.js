var app = new Vue({
        el: '#app',
        data () {
            return {
                info: null
            }
        },
        mounted () {
            axios
                .get('http://localhost:9000/rest/user-desk/user/3')
                .then(response => (this.info = response.data))
        }
    });