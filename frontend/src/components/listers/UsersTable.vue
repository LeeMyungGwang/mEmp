<template>
    <div>
        <v-data-table
                :headers="headers"
                :items="values"
                :items-per-page="5"
                class="elevation-1"
        ></v-data-table>

        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                        v-model="openDialog"
                        width="332.5"
                        fullscreen
                        hide-overlay
                        transition="dialog-bottom-transition"
                >
                    <template v-slot:activator="{ on, attrs }">
                        <v-fab-transition>
                            <v-btn
                                    color="blue"
                                    fab
                                    dark
                                    large
                                    style="position:absolute; bottom: 5%; right: 2%; z-index:99"
                                    @click="openDialog=true;"
                            >
                                <v-icon v-bind="attrs" v-on="on">mdi-plus</v-icon>
                            </v-btn>
                        </v-fab-transition>
                    </template>

                    <Users :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
                    <v-btn
                            style="postition:absolute; top:2%; right:2%"
                            @click="closeDialog()"
                            depressed 
                            icon 
                            absolute
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>
    const axios = require('axios').default;
    import Users from './../Users.vue';

    export default {
        name: 'UsersManager',
        components: {
            Users,
        },
        props: {
            offline: Boolean,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            values: [],
            headers: 
                [
                    { text: "uxid", value: "uxid" },
                    { text: "tenantId", value: "tenantId" },
                    { text: "useStatus", value: "useStatus" },
                    { text: "id", value: "id" },
                    { text: "pass", value: "pass" },
                    { text: "userName", value: "userName" },
                    { text: "createdBy", value: "createdBy" },
                    { text: "createTm", value: "createTm" },
                    { text: "lastModiBy", value: "lastModiBy" },
                    { text: "lastModiTm", value: "lastModiTm" },
                    { text: "phoneNo", value: "phoneNo" },
                    { text: "enterDt", value: "enterDt" },
                    { text: "managerId", value: "managerId" },
                    { text: "rankId", value: "rankId" },
                    { text: "departmentId", value: "departmentId" },
                ],
            users : [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            }

            var temp = await axios.get(axios.fixUrl('/users'))
            temp.data._embedded.users.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.users;

            this.newValue = {
                'uxid': 0,
                'tenantId': '',
                'useStatus': '',
                'pass': '',
                'userName': '',
                'createdBy': '',
                'createTm': '2023-05-16',
                'lastModiBy': '',
                'lastModiTm': '2023-05-16',
                'phoneNo': '',
                'enterDt': '',
                'managerId': '',
                'rankId': {},
                'departmentId': {},
            }
        },
        methods: {
            closeDialog(){
                this.openDialog = false
            },
            append(value){
                this.tick = false
                this.newValue = {}
                this.values.push(value)
                
                this.$emit('input', this.values);

                this.$nextTick(function(){
                    this.tick=true
                })
            },
        }
    }
</script>

