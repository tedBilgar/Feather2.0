Vue.component('user-desks', {
    props: ['userId'],
    template: ' <div class="card-group" style="margin-left: 4%;margin-right: 4%; width: 20%;">\n' +
        '                    <div class="card border border-info" style="margin-left: 0.5%;margin-right: 0.5%; border" v-for="desk in info">\n' +
        '                        <a v-bind:href="/lists/ + desk.desk.id"><img class="card-img-top" src="/img/undraw_posting_photo.svg" alt="Card image cap">\n' +
        '                        <div class="card-body">\n' +
        '                            <p class="card-text">{{ desk.desk.name }}</p>\n' +
        '                        </div></a>\n' +
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

});

new Vue({
    el: '#app'
});