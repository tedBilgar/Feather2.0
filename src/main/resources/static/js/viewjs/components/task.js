Vue.component('user-tasks', {
    props: ['tasklistId'],
    template: '<div class="card-group" style="margin-left: 4%;margin-right: 4%;">\n' +
        '                    <div class="card border border-info" style="max-width: 20%; margin-left: 0.5%;margin-right: 0.5%; border" v-for="list in info">\n' +
        '                        <img class="card-img-top" src="/img/undraw_posting_photo.svg" alt="Card image cap">\n' +
        '                        <div class="card-body">\n' +
        '                            <p class="card-text">{{ list.name }}</p>\n' +
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
            .get('http://localhost:9000/rest/task/tasklist/' + this.tasklistId)
            .then(response => (this.info = response.data))
    }

});

new Vue({
    el: '#app'
});