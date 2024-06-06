function fetchNotices() {
    axios.get('/notices')
        .then(response => {
            const notices = response.data;
            const noticeBoard = document.getElementById('noticeBoard');
            noticeBoard.innerHTML = '';

            notices.forEach(notice => {
                const noticeElement = document.createElement('div');
                noticeElement.classList.add('notice');
                noticeElement.innerHTML = `
                    <h3>${notice.title}</h3>
                    <p>${notice.content}</p>
                    <div class="notice-actions">
                        <button class="btn btn-gray role-admin" onclick="editNotice(${notice.id})">编辑</button>
                        <button class="btn btn-gray role-admin" onclick="deleteNotice(${notice.id})">删除</button>
                    </div>
                `;
                noticeBoard.appendChild(noticeElement);
            });

            // Role check logic for dynamically added elements
            const allRoleElements = document.querySelectorAll('[class*="role-"]');
            allRoleElements.forEach(element => {
                if (userRole === 'admin' && element.classList.contains('role-admin')) {
                    element.style.display = element.getAttribute('data-display');
                } else if (userRole === 'student' && element.classList.contains('role-student')) {
                    element.style.display = element.getAttribute('data-display');
                } else {
                    element.style.display = 'none';
                }
            });
        })
        .catch(error => {
            console.error('Error fetching notices:', error);
        });
}


function showAddNoticeForm() {
    document.getElementById('addNoticeForm').style.display = 'block';
}

function hideAddNoticeForm() {
    document.getElementById('addNoticeForm').style.display = 'none';
}

function addNotice() {
    const form = document.getElementById('noticeForm');
    const data = {
        title: form.noticeTitle.value,
        content: form.noticeContent.value
    };

    axios.post('/notices', data)
        .then(response => {
            alert('公告添加成功');
            form.reset();
            hideAddNoticeForm();
            fetchNotices();
        })
        .catch(error => {
            console.error('Error adding notice:', error);
            alert('公告添加失败');
        });
}

function editNotice(noticeId) {
    // 获取当前公告内容，填充到表单中，进行编辑
    axios.get(`/notices/${noticeId}`)
        .then(response => {
            const notice = response.data;
            document.getElementById('noticeTitle').value = notice.title;
            document.getElementById('noticeContent').value = notice.content;
            showAddNoticeForm();

            const saveButton = document.querySelector('#addNoticeForm button[onclick="addNotice()"]');
            saveButton.setAttribute('onclick', `saveNotice(${noticeId})`);
        })
        .catch(error => {
            console.error('Error fetching notice:', error);
        });
}

function saveNotice(noticeId) {
    const form = document.getElementById('noticeForm');
    const data = {
        title: form.noticeTitle.value,
        content: form.noticeContent.value
    };

    axios.put(`/notices/${noticeId}`, data)
        .then(response => {
            alert('公告更新成功');
            form.reset();
            hideAddNoticeForm();
            fetchNotices();

            // 恢复添加按钮的功能
            const saveButton = document.querySelector('#addNoticeForm button[onclick^="saveNotice"]');
            saveButton.setAttribute('onclick', 'addNotice()');
        })
        .catch(error => {
            console.error('Error updating notice:', error);
            alert('公告更新失败');
        });
}

function deleteNotice(noticeId) {
    if (confirm('确定要删除这个公告吗？')) {
        axios.delete(`/notices/${noticeId}`)
            .then(response => {
                alert('公告删除成功');
                fetchNotices();
            })
            .catch(error => {
                console.error('Error deleting notice:', error);
                alert('公告删除失败');
            });
    }
}
