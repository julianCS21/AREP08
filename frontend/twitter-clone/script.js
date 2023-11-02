function submitPost() {
    const postText = document.getElementById('postText').value;
    if (postText !== '') {
        createPost(postText);
        document.getElementById('postText').value = '';
    } else {
        alert('Por favor, escribe algo para publicar.');
    }
}

function createPost(text) {
    const postList = document.getElementById('postList');

    const postDiv = document.createElement('div');
    postDiv.classList.add('post');

    const postContent = document.createElement('p');
    postContent.textContent = text;

    postDiv.appendChild(postContent);
    postList.appendChild(postDiv);
}



function showLastTenPosts() {
    

    const postList = document.getElementById('postList');
    postList.innerHTML = '';
    const start = Math.max(0, posts.length - 10);
    for (let i = start; i < posts.length; i++) {
        const postElement = document.createElement('div');
        postElement.className = 'post';
        postElement.innerText = posts[i];
        postList.appendChild(postElement);
    }
}

