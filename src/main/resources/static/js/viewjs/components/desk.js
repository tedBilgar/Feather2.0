Vue.component('user-desks', {
    props: ['userId'],
    template: ' <div class="card-group" style="margin-left: 4%;margin-right: 4%;">\n' +
        '                    <div class="card border border-info" style="width: 18rem; margin-left: 0.5%;margin-right: 0.5%; border" v-for="desk in info">\n' +
        '                        <img class="card-img-top" src="/img/undraw_posting_photo.svg" alt="Card image cap">\n' +
        '                        <div class="card-body">\n' +
        '                            <p class="card-text">{{ desk.desk.name }}</p>\n' +
        '                        </div>\n' +
        '                    </div>\n' +
        '                </div>',
    data () {
        return {
            info: null
        }
    },
    mounted () {
        axios
            .get('http://localhost:9000/rest/user-desk/user/'+ this.userId)
            .then(response => (this.info = response.data))
    }

})