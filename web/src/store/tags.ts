import {defineStore} from "pinia";

interface ListItem {
    name: string
    path: string
    title: string
}

export const useTagsStore = defineStore('tags', {
    state: () => {
        return {
            list:<ListItem []>[]
        };

    },
    getters: {
        show:state => {
            return state.list.length > 0;
        },

        nameList: state => {
            return state.list.map(item => item.name);
        }
    },
    actions: {
        deleteTagItem(index: number) {
            this.list.splice(index, 1);
        },
        setTagItem(data: ListItem) {
            this.list.push(data);
        },
        clearTags() {
            this.list = [];
        },
        closeTagsOther(data: ListItem[]) {
            this.list = data;
        },
        closeCurrentTag(data: any) {
            for(let i = 0, len = this.list.length; i < len; i ++) {
                const item = this.list[i];
                if(item.path === data.$route.fullPath) {
                    if(i < len - 1) {
                        data.$route.push(this.list[i + 1].path);
                    } else if(i > 0) {
                        data.$route.push(this.list[i - 1].path);
                    } else {
                        data.$route.push('/');
                    }

                    this.list.splice(i, 1);
                    break;
                }
            }
        },

    }
})